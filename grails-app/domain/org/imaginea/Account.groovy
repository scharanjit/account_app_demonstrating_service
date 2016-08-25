package org.imaginea

class Account {

    String accountName
    int balance

    static constraints = {
        accountName(unique:true,nullable:false)
        balance()
    }
}
