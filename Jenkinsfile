node {
    stage ("Build") {
        checkout scm
        bat("mvn verify")
    }

    stage ("Record issues") {
        recordIssues tool: pmdParser(pattern: '**/target/pmd.xml'), 
                             qualityGates: [[threshold: 1, type: 'TOTAL', unstable: true]]
        recordIssues([tool: checkStyle(pattern: '**/target/checkstyle-result.xml'),
            sourceCodeEncoding: 'UTF-8',
            skipBlames: true,
            trendChartType: 'TOOLS_ONLY',
            qualityGates: [[threshold: 1, type: 'TOTAL', unstable: true]]])
    }
}
