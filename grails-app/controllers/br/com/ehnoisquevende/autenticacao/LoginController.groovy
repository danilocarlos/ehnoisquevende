package br.com.ehnoisquevende.autenticacao

import br.com.ehnoisquevende.Usuario;

class LoginController {

    def index() { }
	
	def autenticar(String usuario, String senha){
		if(!usuario || !senha){
			flash.mensagem = "Digite login e senha"
			redirect(controller:"login")
			return
		}else{
			def usuarioLogado = Usuario.findByLoginAndSenha(usuario,senha.encodeAsMD5())
			if(usuarioLogado){
				session.usuario = usuarioLogado
				redirect(controller:"index")
			}else{
				flash.mensagem = "Usuario e senha invalido!"
				redirect(controller:"login")
				return
			}
		}
	}
	def logout(){
		session.invalidate()
		redirect(controller:"login")
	}
}
