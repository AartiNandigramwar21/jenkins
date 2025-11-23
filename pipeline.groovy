pipeline {
    agent {label 'slave'}
    stages {
        stage('pull-stage') {
            steps {
                git branch: 'main', url: 'https://github.com/Anilbamnote/student-ui-app.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('test') {
            steps {
                echo "test suecss"
            }
        }
        stage('deploy') {
            steps {
                echo "deploy sucess"
            }
        }
    }
}