import org.imaginea.Account

class BootStrap {

    def init = { servletContext ->
        def account= new Account(accountName:"checking",balance: 10000)
        account.save()
        account = new Account(accountName: "saving",balance: 500)
        account.save()
        if(account.hasErrors()){
            println account.errors
        }
    }
    def destroy = {
    }
}
