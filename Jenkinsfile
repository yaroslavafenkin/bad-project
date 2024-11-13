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
            
        junit (
         testResults: '**/surefire-reports/*.xml',
         testDataPublishers: [
           jiraTestResultReporter(
             configs: [
               jiraStringField(fieldKey: 'summary', value: '${DEFAULT_SUMMARY}'),
               jiraStringField(fieldKey: 'description', value: '${DEFAULT_DESCRIPTION}'),
               jiraStringArrayField(fieldKey: 'labels', values: [jiraArrayEntry(value: 'Jenkins'), jiraArrayEntry(value:'Integration')])
             ],
             projectKey: 'J2J',
             issueType: '1',
             autoRaiseIssue: false,
             autoResolveIssue: false,
             autoUnlinkIssue: false,
             additionalAttachments: false,
           )
         ]
        )
    }
}
