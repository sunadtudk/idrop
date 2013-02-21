package org.irods.mydrop.controller

import org.irods.jargon.core.connection.IRODSAccount
import org.irods.jargon.core.pub.IRODSAccessObjectFactory
import org.irods.jargon.hive.service.VocabularyService

class HiveController {

	IRODSAccessObjectFactory irodsAccessObjectFactory
	IRODSAccount irodsAccount
	VocabularyService vocabularyService

	/**
	 * Interceptor grabs IRODSAccount from the SecurityContextHolder
	 */
	def beforeInterceptor = [action:this.&auth]

	def auth() {
		/*
		 if(!session["SPRING_SECURITY_CONTEXT"]) {
		 redirect(controller:"login", action:"login")
		 return false
		 }
		 irodsAccount = session["SPRING_SECURITY_CONTEXT"]
		 */
	}


	def afterInterceptor = {
		log.debug("closing the session")
		irodsAccessObjectFactory.closeSession()
	}


	def index() {
		log.info("getting vocab names")
		List<String> vocabs = vocabularyService.getAllVocabularyNames()
		render(view:"vocabList", model:[vocabs:vocabs])
	}
	
	def showTreeForSelectedVocabularies(){
		render(view:"conceptBrowser")
	}
	
}