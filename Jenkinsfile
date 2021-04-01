
@Grab("org.jodd:jodd-http:3.8.5")
import jodd.http.HttpRequest

import groovy.json.JsonOutput
import groovy.json.JsonBuilder

node {

def buildApp(String morpheusUrl, Map<?, ?> postBody, String bearerToken) {
	String jsoncontent = new JsonBuilder(postBody).toString()
	
 postJson(morpheusUrl, postBody, bearerToken)
}
 
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

stage('Clone repository') {
        /* Let's make sure we have the repository cloned to our workspace */

        checkout scm
    };
       

    stage('Creating Morpheus Blueprint ') {
          
        withCredentials([string(credentialsId: 'token0104', variable: 'bearer')]) {
            String morpheusUrl = 'https://devlmorph001.techlab.com/api/blueprints'

            Map<?, ?> postBody = [
  "name": "sample",
  "description": "A sample blueprint",
  "type": "morpheus",
  "tiers": [
    "Web": [
      "instances": [
        [
          "instance": [
            "cloud": "AWS",
            "type": "tomcat",
            "layout": [
              "code": "tomcat-amazon-7.0.62-single",
              "id": 616
            ]
          ],
          "config": [
            "publicIpType": "subnet",
            "resourcePoolId": 129
          ],  
         
          "volumes": [
            [
              "vId": 374,
              "volumeCustomizable": true,
              "readonlyName": true,
              "size": 20,
              "maxIOPS": null,
              "name": "root",
              "rootVolume": true,
              "storageType": 6,
              "maxStorage": 0
            ]
          ]
        ]
      ],
      "tierIndex": 0
    ],
    "Database": [
      "instances": [
        [
          "instance": [
            "cloud": "AWS",
            "type": "mysql",
            "layout": [
              "code": "mysql-amazon-5.6-single",
              "id": 439
            ]
          ],
          "config": [
            "publicIpType": "subnet",
            "resourcePoolId": 129
          ],
          "volumes": [
            [
              "vId": 508413,
              "volumeCustomizable": true,
              "readonlyName": false,
              "size": 15,
              "maxIOPS": null,
              "name": "root",
              "rootVolume": true,
              "storageType": 6,
              "maxStorage": 0
            ]
          ]
        ]
      ],
      "tierIndex": 1
    ]
  ],
  "config": [
    "isEC2": false,
    "isVpcSelectable": false
  ]
]


echo buildApp(morpheusUrl, postBody, "${bearer}")
        }
    }
}
