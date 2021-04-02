import groovy.json.JsonBuilder
import org.GroovyClient.JenkinsHttpClient

def buildApp(String morpheusUrl, Map<?, ?> postBody, String bearerToken) {
	String jsoncontent = new JsonBuilder(postBody).toString()
	org.GroovyClient.JenkinsHttpClient http = new org.GroovyClient.JenkinsHttpClient()
	http.postJson(morpheusUrl, postBody, bearerToken)
}
 
}

return this;