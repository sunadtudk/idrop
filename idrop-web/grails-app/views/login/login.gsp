<!DOCTYPE html>
<html lang="en">
<head>
<title>iDrop-web - iRODS Personal Cloud"</title>
<meta name="layout" content="basic" />
</head>

<div class="row-fluid">
	<div class="span5 offset4">
		<div id="normalLoginForm" class="well">

			<g:form id="normalLogin" method="post" controller="login"
				action="authenticate">


				<g:hiddenField name="usePresets" id="usePresets"
					value="${loginCommand.usePresets}" />
				<g:hasErrors bean="${loginCommand}">
					<div class="alert alert-error">
						<ul>
							<g:eachError var="err" bean="${loginCommand}">
								<li><g:message error="${err}" /></li>
							</g:eachError>
						</ul>
					</div>
				</g:hasErrors>

				<div id="container" style="height: auto; width: auto;">

					<g:if test="${loginCommand.usePresets}">

						<g:hiddenField name="host" id="host" value="${loginCommand.host}" />
						<g:hiddenField name="port" id="port" value="${loginCommand.port}" />
						<g:hiddenField name="zone" id="zone" value="${loginCommand.zone}" />
						<g:hiddenField name="defaultStorageResource" id="resource"
							value="${loginCommand.defaultStorageResource}" />
						<g:hiddenField name="authMethod" id="authMethod"
							value="${loginCommand.authMethod}" />
					</g:if>
					<g:else>
						<div>
							<div style="width: 30%;">
								<label><g:message code="text.host" />:</label>
							</div>
							<div>
								<input type="text" class="input-text" name="host" id="host"
									value="${loginCommand.host}" />
							</div>
						</div>
						<div>
							<div>
								<label><g:message code="text.port" />:</label>
							</div>
							<div>
								<input type="text" class="input-text" name="port" id="port"
									value="${loginCommand.port}" />
							</div>
						</div>
						<div>
							<div>
								<label><g:message code="text.zone" />:</label>
							</div>
							<div>
								<input type="text" class="input-text" name="zone" id="zone"
									value="${loginCommand.zone}" />
							</div>
						</div>
						<div>
							<div>
								<label><g:message code="text.auth.method" />:</label>
							</div>
							<div>
								<g:select name="authMethod" from="${['Standard', 'PAM']}"
									value="${loginCommand.authMethod}" />
							</div>
						</div>
					</g:else>

					<div>
						<div>
							<label><g:message code="text.guest.login" />:</label>
						</div>
						<div>
							<g:checkBox name="useGuestLogin" id="useGuestLogin"
								value="${loginCommand.useGuestLogin}"
								onclick="toggleGuestLogin()" />
						</div>
					</div>

					<div class="userLoginData">
						<div>
							<label><g:message code="text.user" />:</label>
						</div>
						<div>
							<input type="text" class="input-text" name="user" id="user"
								value="${loginCommand.user}" />
						</div>
					</div>
					<div class="userLoginData">
						<div>
							<label><g:message code="text.password" />:</label>
						</div>
						<div>
							<input type="password" class="input-text" name="password"
								id="password" value="${loginCommand.password}" />
						</div>
					</div>

					</span>
					<div>
						<div></div>
						<div>
							<button id="login" name="login"
								style="margin-left: 150px; margin-top: 20px; margin-bottom: 20px;">
								<g:message code="text.login" />
							</button>
						</div>
					</div>
					<g:if test="${!loginCommand.usePresets}">
						<div>
							<div>
								<label><g:message code="text.resource" />:</label>
							</div>
							<div>
								<input type="text" class="input-text" name="resource"
									id="resource" value="${loginCommand.defaultStorageResource}" />
								<stong>
								<g:message code="text.optional" />
								</strong>
							</div>
						</div>
					</g:if>
				</div>
				<!-- container div -->

			</g:form>

			<!--end-normalLogin-->
		</div>

	</div>

</div>
</div>
</div>
</html>
<script>
	$(function() {
		toggleGuestLogin();

	});

	function toggleGuestLogin() {
		var checkVal = $("#useGuestLogin").attr("checked");
		if (checkVal) {
			$(".userLoginData").hide("slow");

		} else {
			$(".userLoginData").show("slow");
		}
	}
</script>



