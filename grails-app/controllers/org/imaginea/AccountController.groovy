package org.imaginea

class AccountController {


    def transfer(){
        def amount=params.amount.toInteger()

        deposit(params.to,amount)
        withdraw(params.from,amount)
        redirect(action:"balances")

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

        def checking_balances=Account.findByAccountName("checking").balance
        def saving_balances=Account.findByAccountName("saving").balance

        render "Checking Balance = " + checking_balances+"\n"+
                "Saving Balance = " + saving_balances


    }
}
