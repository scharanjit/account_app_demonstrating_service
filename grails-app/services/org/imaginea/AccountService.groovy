package org.imaginea

import grails.transaction.Transactional

@Transactional
class AccountService {

    def transfer(from,to,amount){

        deposit(to,amount)
        withdraw(from,amount)

    }

    private def withdraw(from,amount){
        def account =Account.findByAccountName(from)
        account.balance -= amount
        account.save()
        if(account.errors){
            println account.errors
        }

    }

    private def deposit(to,amount){
        def account =Account.findByAccountName(to)
        account.balance += amount
        account.save()
        if(account.errors){
            println account.errors
        }

    }

    def balances(){
        def checking_balances = Account.findByAccountName("checking").balance
        def saving_balances = Account.findByAccountName("saving").balance

        return "Checking Balance = " + checking_balances+"\n"+
          "Saving Balance = " + saving_balances
    }
}
