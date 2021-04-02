
package org.GroovyClient

import groovy.json.JsonBuilder

import jodd.http.HttpRequest

/**
 * Helper class for making REST calls from a Jenkins Pipeline job.
 */
public class JenkinsHttpClient {

    private HttpRequest httpRequest
    
    JenkinsHttpClient() {
        httpRequest = new HttpRequest()
    } 

    /**
     * POST method, convert body Map to applicationjson.
     * @param url
     * @param body
     * @return response body as String
     */
    def postJson(String url, Map<?, ?> body, String bearerToken) {
	String jsonbody = new JsonBuilder(body).toString()
        String token = 'BEARER' + bearerToken
	def resp = httpRequest.post(url)
                .header('Authorization', token)
                .contentType('application/json')
                .body(jsonbody)
                .send()
        return resp.bodyText()
    }
}
