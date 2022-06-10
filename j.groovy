pipeline {
    agent any
    parameters {
        string(name: 'ACX_BOM_ID', defaultValue: 'acx_bom_id', description: '')
    }

    options {
        buildDiscarder(logRotator(numToKeepStr: '30', artifactNumToKeepStr: ''))
    }
    

    stages {
        stage('false') {
            steps {
                script {
                    currentBuild.displayName = "${ACX_BOM_ID}"
                }
                sh 'echo "hello"'
            }
        }

      stage('true') {
            steps {
                // catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                //     build job: 'ttt', propagate: false
                // }
                build job: 'ttt', propagate: false
            }
        }
    }


    // post {
    //     always {
    //         step([
    //                 $class : 'RobotPublisher',
    //                 outputPath : '$WORK_DIR/report',
    //                 outputFileName : 'output.xml',
    //                 logFileName: 'log.html',
    //                 reportFileName: 'report.html',
    //                 disableArchiveOutput : false,
    //                 passThreshold : 90.0,
    //                 unstableThreshold: 80.0,
    //                 otherFiles : "*.png",
    //             ]
    //         )
    //     }
    // }


}
