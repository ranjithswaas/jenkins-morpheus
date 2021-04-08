@Library('jenkins-pipeline-shared-lib')_
import groovy.json.JsonOutput

node {



    stage('Create Groups'){
    
        

    }

    stage('Creating Morpheus Blueprint ') {
          
        withCredentials([string(credentialsId: 'MorphToken', variable: 'bearer')]) {
            String morpheusUrl = 'https://devlmorph001.techlab.com/api/blueprints'

            Map<?, ?> postBody = [
                                  "name": "Polaris-AutomatedBlueprint",
                                  "description": "Blueprint created from jenkins pipeline",
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
          def token = '${bearer}'
 
          echo morpheusApp.buildApp(morpheusUrl, postBody, token)
        }
    }
}
