pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    // Run the Gradle build
                    sh './gradlew assemble'
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    // Run the Gradle tests
                    sh './gradlew test'
                }
            }
        }
    }

    post {
        success {
            echo 'Build and Tests were successful!'
        }
        failure {
            echo 'Build or Tests failed. Please check the logs.'
        }
    }
}