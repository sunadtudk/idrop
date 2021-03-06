package org.irods.jargon.idrop.lite.finder;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.TableModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import org.irods.jargon.core.exception.JargonException;
import org.irods.jargon.core.pub.io.IRODSFile;
import org.irods.jargon.core.pub.io.IRODSFileFactory;
import org.irods.jargon.core.query.CollectionAndDataObjectListingEntry;
import org.irods.jargon.core.transfer.TransferStatus;
import org.irods.jargon.core.transfer.TransferStatus.TransferState;
import org.irods.jargon.idrop.lite.IRODSFileSystemModel;
import org.irods.jargon.idrop.lite.IRODSNode;
import org.irods.jargon.idrop.lite.IRODSOutlineModel;
import org.irods.jargon.idrop.lite.IRODSTree;
import org.irods.jargon.idrop.lite.iDropLiteCore;
import org.irods.jargon.idrop.lite.iDropLiteApplet;
import org.irods.jargon.idrop.lite.TreeUtils;
import org.irods.jargon.idrop.lite.IdropException;
import org.irods.jargon.idrop.lite.IdropRuntimeException;
import org.netbeans.swing.outline.DefaultOutlineModel;
import org.netbeans.swing.outline.RowModel;
import org.slf4j.LoggerFactory;

/**
 * @author Mike Conway - DICE (www.irods.org)
 */
public class IRODSFinderOutlineModel extends DefaultOutlineModel {

    public static final org.slf4j.Logger log = LoggerFactory.getLogger(IRODSFinderOutlineModel.class);
    private final IRODSFileSystemModel treeModel;
    private final IRODSFinderTree irodsFinderTree;
    private final iDropLiteCore idropCore;

    public IRODSFileSystemModel getTreeModel() {
        return treeModel;
    }

    public IRODSFinderOutlineModel(final iDropLiteCore idropCore, final IRODSFinderTree irodsFinderTree, final TreeModel tm,
            final TableModel tm1, final boolean bln, final String string) {
        super(tm, tm1, bln, string);
        this.treeModel = (IRODSFileSystemModel) tm;
        this.irodsFinderTree = irodsFinderTree;
        this.idropCore = idropCore;
    }

    public IRODSFinderOutlineModel(final iDropLiteCore idropCore,final IRODSFinderTree irodsFinderTree,final TreeModel tm,
            final RowModel rm, final boolean bln, final String string) {
        super(tm, rm, bln, string);
        this.treeModel = (IRODSFileSystemModel) tm;
        this.irodsFinderTree = irodsFinderTree;
        this.idropCore = idropCore;
    }
    
     public void notifyFileShouldBeRemoved(final IRODSNode deletedNode)
            throws IdropException {

        if (deletedNode == null) {
            return;
        }
        log.info("deleting node from parent:{}", deletedNode);
        final IRODSNode parent = (IRODSNode) deletedNode.getParent();

        if (parent == null) {
            return;
        }

        final IRODSFinderOutlineModel thisModel = this;

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                deletedNode.getUserObject();
                CollectionAndDataObjectListingEntry entry = (CollectionAndDataObjectListingEntry) (parent).getUserObject();
        
                try {
                    FinderUtils.buildTreePathForIrodsAbsolutePath(
                            irodsFinderTree, entry.getFormattedAbsolutePath());

                } catch (IdropException ex) {
                    Logger.getLogger(IRODSOutlineModel.class.getName()).log(
                            Level.SEVERE, null, ex);
                    throw new IdropRuntimeException(ex);
                }

                treeModel.removeNodeFromParent(deletedNode);

            }
        });
    }

 
    public void notifyFileShouldBeAdded(final IRODSTree irodsTree,
            final String irodsFileAbsolutePath) {
        log.info("notifyFileShouldBeAdded() for node:{}", irodsFileAbsolutePath);

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {

                IRODSFileFactory irodsFileFactory = idropCore.getIRODSFileFactoryForLoggedInAccount();
                try {
                    try {
                        // if the node already exists (e.g. an overwrite, don'
                        // add it

                        TreePath currentPath = TreeUtils.buildTreePathForIrodsAbsolutePath(irodsTree,
                                irodsFileAbsolutePath);
                        // build treePath will return parent if child not found
                        if (currentPath == null) {
                            log.warn(
                                    "null tree path found for:{} logged and ignored as a warning",
                                    irodsFileAbsolutePath);
                            return;
                        }
                        IRODSNode irodsNode = (IRODSNode) currentPath.getLastPathComponent();
                        CollectionAndDataObjectListingEntry lastPathNodeEntry = (CollectionAndDataObjectListingEntry) irodsNode.getUserObject();
                        if (irodsFileAbsolutePath.equals(lastPathNodeEntry.getFormattedAbsolutePath())) {
                            log.info("path already exists, do not double-add");
                            return;
                        }

                    } catch (IdropException ex) {
                        Logger.getLogger(IRODSOutlineModel.class.getName()).log(Level.SEVERE, null, ex);
                        throw new IdropRuntimeException(ex);
                    }

                    IRODSFile addedFile = irodsFileFactory.instanceIRODSFile(irodsFileAbsolutePath);
                    if (!addedFile.exists()) {
                        log.info(
                                "looking for file that was added, I don't find it, so just move on: {}",
                                irodsFileAbsolutePath);
                        return;
                    }
                    TreePath parentPath;
                    try {
                        parentPath = TreeUtils.buildTreePathForIrodsAbsolutePath(irodsTree,
                                addedFile.getParent());
                    } catch (IdropException ex) {
                        Logger.getLogger(IRODSOutlineModel.class.getName()).log(Level.SEVERE, null, ex);
                        throw new IdropRuntimeException(ex);
                    }

                    if (parentPath == null) {
                        log.info("null path for lookup, just move on");
                        return;
                    }
                    log.info("building a new node");
                    CollectionAndDataObjectListingEntry newEntry = new CollectionAndDataObjectListingEntry();
                    newEntry.setCreatedAt(new Date(addedFile.lastModified()));
                    newEntry.setDataSize(addedFile.length());
                    newEntry.setModifiedAt(new Date(addedFile.lastModified()));

                    if (addedFile.isDirectory()) {
                        newEntry.setObjectType(CollectionAndDataObjectListingEntry.ObjectType.COLLECTION);
                        newEntry.setParentPath(addedFile.getParent());
                        newEntry.setPathOrName(addedFile.getAbsolutePath());
                    } else {
                        newEntry.setObjectType(CollectionAndDataObjectListingEntry.ObjectType.DATA_OBJECT);
                        newEntry.setParentPath(addedFile.getParent());
                        newEntry.setPathOrName(addedFile.getName());
                    }

                    IRODSNode newNode = new IRODSNode(newEntry, idropCore.getIrodsAccount(), idropCore.getIrodsFileSystem(), irodsTree);
                    ((IRODSNode) parentPath.getLastPathComponent()).add(newNode);
                    irodsTree.highlightPath(parentPath);
                } catch (JargonException ex) {
                    Logger.getLogger(IRODSOutlineModel.class.getName()).log(
                            Level.SEVERE, null, ex);
                } finally {
                    idropCore.closeIRODSConnectionForLoggedInAccount();
                }
            }
        });
    }

}

