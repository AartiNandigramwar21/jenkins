pipeline {
    agent {label 'slave'}
    stages {
        stage('pull-stage') {
            steps {
                // git branch: 'main', url: 'https://github.com/Anilbamnote/student-ui-app.git'
               git branch: 'main', url: 'https://github.com/Rupen04/artifact_pom.git'
            }
        }
        stage('Build') {
            steps {
                sh '/opt/maven/bin/mvn clean package'
            }
        }
        stage('test') {
            steps { 
              sh '''mvn sonar:sonar \\
               -Dsonar.projectKey=token2 \\
               -Dsonar.host.url=http://13.201.94.168:9000 \\
               -Dsonar.login=3bfe86b7e5ecf5c4a647dcd7c8b1ef6cdfe312db'''
             }
        }
        stage('deploy') 
            steps {
                echo "deploy sucess"
            }
        }
    }
