package org.imaginea

class AccountController {

    def accountService

    def index(){

    }
    def transfer(){
       accountService.transfer(params.from,params.to,params.amount.toInteger())
        redirect(action:"balances")
    }



    def balances(){
        render accountService.balances()
    }
}
