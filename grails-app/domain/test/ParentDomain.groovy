package test

class ParentDomain {

    ParentType type
    EmbeddedDomain embeddedDomain

    static embedded = ['embeddedDomain']

    static constraints = {
    }
}

enum ParentType { TYPE_A, TYPE_B}
