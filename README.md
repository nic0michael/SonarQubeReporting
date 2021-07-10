# SonarQubeReporting

## Search for projects in SonarQube
[http://localhost:9001/api/components/search_projects](http://localhost:9001/api/components/search_projects)


```
{
   "paging":{
      "pageIndex":1,
      "pageSize":100,
      "total":2
   },
   "components":[
      {
         "key":"com.mycompany:NicosBadProject",
         "name":"NicosBadProject",
         "qualifier":"TRK",
         "isFavorite":false,
         "tags":[
            
         ],
         "visibility":"public",
         "needIssueSync":false
      },
      {
         "key":"za.co.nico:RabbitMqPoc",
         "name":"RabbitMqPoc",
         "qualifier":"TRK",
         "isFavorite":false,
         "tags":[
            
         ],
         "visibility":"public",
         "needIssueSync":false
      }
   ],
   "facets":[
      
   ]
}
```

## Search for issues in all projects

[http://localhost:9001/api/issues/search](http://localhost:9001/api/issues/search)

```
{
   "total":51,
   "p":1,
   "ps":100,
   "paging":{
      "pageIndex":1,
      "pageSize":100,
      "total":51
   },
   "effortTotal":402,
   "issues":[
      {
         "key":"AXlMYApOgcweGMi3pvpV",
         "rule":"xml:S125",
         "severity":"MAJOR",
         "component":"za.co.nico:RabbitMqPoc:pom.xml",
         "project":"za.co.nico:RabbitMqPoc",
         "line":44,
         "hash":"c11bb7eec8b60626961f63cda07648ac",
         "textRange":{
            "startLine":44,
            "endLine":51,
            "startOffset":0,
            "endOffset":8
         },
         "flows":[
            
         ],
         "status":"OPEN",
         "message":"Remove this commented out code.",
         "effort":"5min",
         "debt":"5min",
         "author":"",
         "tags":[
            "unused"
         ],
         "creationDate":"2021-05-08T14:27:02+0000",
         "updateDate":"2021-05-08T14:27:02+0000",
         "type":"CODE_SMELL",
         "scope":"MAIN"
      }
   ],
   "facets":[
      
   ]
}
```

## Search for issues in project : za.co.nico:RabbitMqPoc


[http://localhost:9001/api/issues/search?componentKeys=za.co.nico:RabbitMqPoc](http://localhost:9001/api/issues/search?componentKeys=za.co.nico:RabbitMqPoc)

```
{
   "total":37,
   "p":1,
   "ps":100,
   "paging":{
      "pageIndex":1,
      "pageSize":100,
      "total":37
   },
   "effortTotal":244,
   "issues":[
      {
         "key":"AXlMYAnmgcweGMi3pvpI",
         "rule":"java:S1068",
         "severity":"MAJOR",
         "component":"za.co.nico:RabbitMqPoc:src/main/java/za/co/nico/rabbitmq/poc/validators/RequestValidator.java",
         "project":"za.co.nico:RabbitMqPoc",
         "line":19,
         "hash":"e42cd11faf8bf5680e255fe15e1e8527",
         "textRange":{
            "startLine":19,
            "endLine":19,
            "startOffset":30,
            "endOffset":47
         },
         "flows":[
            
         ],
         "status":"OPEN",
         "message":"Remove this unused ""VALIDATION_PASSED"" private field.",
         "effort":"5min",
         "debt":"5min",
         "author":"nicomichael2012@gmail.com",
         "tags":[
            "unused"
         ],
         "creationDate":"2021-04-02T18:48:11+0000",
         "updateDate":"2021-05-08T14:27:02+0000",
         "type":"CODE_SMELL",
         "scope":"MAIN"
      },
      {
         "key":"AXlMYAnmgcweGMi3pvpJ",
         "rule":"java:S1068",
         "severity":"MAJOR",
         "component":"za.co.nico:RabbitMqPoc:src/main/java/za/co/nico/rabbitmq/poc/validators/RequestValidator.java",
         "project":"za.co.nico:RabbitMqPoc",
         "line":23,
         "hash":"fea5f208ea0826bb82064ac9696c1959",
         "textRange":{
            "startLine":23,
            "endLine":23,
            "startOffset":29,
            "endOffset":56
         },
         "flows":[
            
         ],
         "status":"OPEN",
         "message":"Remove this unused ""failedToSendToQueueResponse"" private field.",
         "effort":"5min",
         "debt":"5min",
         "author":"nicomichael2012@gmail.com",
         "tags":[
            "unused"
         ],
         "creationDate":"2021-04-02T18:48:11+0000",
         "updateDate":"2021-05-08T14:27:02+0000",
         "type":"CODE_SMELL",
         "scope":"MAIN"
      },
      {
         "key":"AXlMYAmSgcweGMi3pvo8",
         "rule":"java:S2139",
         "severity":"MAJOR",
         "component":"za.co.nico:RabbitMqPoc:src/main/java/za/co/nico/rabbitmq/poc/services/impl/MessageQueueSendServiceImpl.java",
         "project":"za.co.nico:RabbitMqPoc",
         "line":76,
         "hash":"0ddff5c0b9711fe1cb6144ecbfc4e17a",
         "textRange":{
            "startLine":76,
            "endLine":76,
            "startOffset":11,
            "endOffset":33
         },
         "flows":[
            {
               "locations":[
                  {
                     "component":"za.co.nico:RabbitMqPoc:src/main/java/za/co/nico/rabbitmq/poc/services/impl/MessageQueueSendServiceImpl.java",
                     "textRange":{
                        "startLine":77,
                        "endLine":77,
                        "startOffset":3,
                        "endOffset":122
                     },
                     "msg":"Logging statement."
                  }
               ]
            },
            {
               "locations":[
                  {
                     "component":"za.co.nico:RabbitMqPoc:src/main/java/za/co/nico/rabbitmq/poc/services/impl/MessageQueueSendServiceImpl.java",
                     "textRange":{
                        "startLine":78,
                        "endLine":78,
                        "startOffset":9,
                        "endOffset":44
                     },
                     "msg":"Thrown exception."
                  }
               ]
            }
         ],
         "status":"OPEN",
         "message":"Either log this exception and handle it, or rethrow it with some contextual information.",
         "effort":"15min",
         "debt":"15min",
         "author":"nicomichael2012@gmail.com",
         "tags":[
            "clumsy",
            "error-handling"
         ],
         "creationDate":"2021-05-08T13:03:12+0000",
         "updateDate":"2021-05-08T14:27:02+0000",
         "type":"CODE_SMELL",
         "scope":"MAIN"
      }
   ],
   "components":[
      {
         "key":"za.co.nico:RabbitMqPoc:src/main/java/za/co/nico/rabbitmq/poc/enums/ResponseStatusCodes.java",
         "enabled":true,
         "qualifier":"FIL",
         "name":"ResponseStatusCodes.java",
         "longName":"src/main/java/za/co/nico/rabbitmq/poc/enums/ResponseStatusCodes.java",
         "path":"src/main/java/za/co/nico/rabbitmq/poc/enums/ResponseStatusCodes.java"
      },
      {
         "key":"za.co.nico:RabbitMqPoc:pom.xml",
         "enabled":true,
         "qualifier":"FIL",
         "name":"pom.xml",
         "longName":"pom.xml",
         "path":"pom.xml"
      },
      {
         "key":"za.co.nico:RabbitMqPoc:src/main/java/za/co/nico/rabbitmq/poc/utils/Utils.java",
         "enabled":true,
         "qualifier":"FIL",
         "name":"Utils.java",
         "longName":"src/main/java/za/co/nico/rabbitmq/poc/utils/Utils.java",
         "path":"src/main/java/za/co/nico/rabbitmq/poc/utils/Utils.java"
      }
   ],
   "facets":[
      
   ]
}
```

## Tools used :
[https://jsonformatter.curiousconcept.com/#](https://jsonformatter.curiousconcept.com/#)
