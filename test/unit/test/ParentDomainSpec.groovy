package test

import grails.test.mixin.*
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(ParentDomain)
@Mock(EmbeddedDomain)
class ParentDomainSpec extends Specification {

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
