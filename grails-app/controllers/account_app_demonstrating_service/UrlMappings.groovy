package account_app_demonstrating_service

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }


        "/"(controller: 'account', action: 'balances')
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
