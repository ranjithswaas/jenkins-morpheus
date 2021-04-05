@Library('jenkins-pipeline-shared-lib')_
import groovy.json.JsonOutput
import groovy.json.JsonBuilder 
node {

 

stage('Clone repository') {
        /* Let's make sure we have the repository cloned to our workspace */

        checkout scm
    };
       

    stage('Creating Morpheus Blueprint ') {
          
        withCredentials([string(credentialsId: 'MorphToken', variable: 'bearer')]) {
            String morpheusUrl = 'http://devlmorph001.techlab.com/api/blueprints'

            Map<?, ?> postBody = [
  "name": "Polaris-Automated",
  "description": "Blueprint created from jenkins pipeline",
  "type": "morpheus",
  "tiers": [
    "Web": [
      "instances": [
        [
          "instance": [
            "type": "tomcat",
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
String jsonbody = new JsonBuilder(postBody).toString()


println jsonbody
def apiToken = '4e996abc-cbc1-4244-84f4-f5f5126a56ef'
println apiToken
echo morpheusApp.buildApp(morpheusUrl, postBody, apiToken)
        }
    }
}
