package test

import grails.plugin.spock.IntegrationSpec

class ParentDomainIntegrationSpec extends IntegrationSpec {

    void 'find parent by type'() {
        given:
        def parentOfTypeA = new ParentDomain(
            type: ParentType.TYPE_A,
            embeddedDomain: new EmbeddedDomain(type: 'Embedded Type A')
        ).save(failOnError: true)

        and:
        new ParentDomain(
            type: ParentType.TYPE_B,
            embeddedDomain: new EmbeddedDomain(type: 'Embedded Type B')
        ).save(failOnError: true)

        expect:
        ParentDomain.findByType(ParentType.TYPE_A) == parentOfTypeA
    }

}
