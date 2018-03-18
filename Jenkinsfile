podTemplate(
  label: 'test',
  containers: [
    containerTemplate(name: 'maven', image: 'maven:3.3.9-jdk-8-alpine', ttyEnabled: true, command: 'cat'),
    containerTemplate(name: 'docker', image: 'docker', command: 'cat', ttyEnabled: true)
  ],
  volumes: [
    hostPathVolume(mountPath: '/var/run/docker.sock', hostPath: '/var/run/docker.sock'),
    persistentVolumeClaim(mountPath: '/root/.m2/repository', claimName: 'pvc.maven', readOnly: false)
  ]
) {
  //env.GIT_COMMIT = sh(script: "git rev-parse HEAD", returnStdout: true).trim()
  // echo env.GIT_COMMIT

  node('test') {
    stage('Preparation') {
      checkout scm
    }

    stage('Build project with maven') {
      container('maven') {
        sh 'mvn clean package'
      }
    }
  }
}
