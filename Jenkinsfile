pipeline {
    agent any
    stages {
        stage ('Develop') {
            steps {
                withMaven(maven : 'maven_3_6_0') {
                    sh 'mvn clean compile'
                }
            }
        }
        stage ('Test') {
            steps {
                withMaven(maven : 'maven_3_6_0') {
                    sh 'mvn test'
                }
            }
        }
		stage ('Package') {
            steps {
                withMaven(maven : 'maven_3_6_0') {
                    sh 'mvn	package	-DskipTests'
                }
            }
        }

        stage ('Deployment') {
            steps {
                withMaven(maven : 'maven_3_6_0') {
                    sh 'mvn deploy'
                }
            }
        }
    }
}
