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
                 
                   withSonarQubeEnv(credentialsId: 'sonar-token2') {
    // some block
    }
}   
                }
        }
        stage('deploy') {
            steps {
                echo "deploy sucess"
            }
        }
    }
}