var accountType;
var accountId;
const url = "https://tiawdoors-api.herokuapp.com/";
var personalInfo = [];
var myVagas = [];

function estudante(cpf, usuario, senha, prenome, sobrenome, email, periodo, curso, telefone, endereco, linkedin, idiomas, skills, foto) {
        this.cpf = cpf;
        this.usuario = usuario;
        this.senha = senha;
        this.prenome = prenome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.periodo = periodo;
        this.curso = curso;
        this.telefone = telefone;
        this.endereco = endereco;
        this.linkedin = linkedin;
        this.idiomas = idiomas;
        this.skills = skills;
        this.foto = foto;                         
                    
}

function prepCabecalho() {
    if (localStorage.getItem("statusLogin") != "1" && localStorage.getItem("statusLogin") != "2" &&
        sessionStorage.getItem("statusLogin") != "1" && sessionStorage.getItem("statusLogin") != "2") {
        document.querySelector(".navConect").innerHTML =
            `<a class="nav-link responsivo" href="../resources/login.html">Conectar</a>`;
        document.querySelector(".login .dropdown").innerHTML =
            `<div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item" href="../resources/login.html">Conectar</a>
                </div>`;
    } else {
        document.querySelector(".navConect").innerHTML =
            `<a class="nav-link responsivo" href="../resources/perfil.html">Meu perfil</a>
                <a class="nav-link responsivo" href="#" onclick="Desconect()">Desconectar</a>`;
        document.querySelector(".login .dropdown").innerHTML =
            `<div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item" href="../resources/perfil.html">Meu perfil</a>
                    <a class="dropdown-item" href="#" onclick="Desconect()">Desconectar</a>
                </div>`;
    }
}

function Desconect() {
    localStorage.setItem("statusLogin", "0");
    sessionStorage.setItem("statusLogin", "0");
    localStorage.setItem("userId", "0");
    sessionStorage.setItem("userId", "0");
    location = location;
}

function getData() {
    $.ajax({
        url: url + accountType + '?userid=' + accountId,
    })
        .done(function (data) {
            personalInfo = data;
            montarPerfil();
            opcoesComun();
        });
}

function opcoesComun() {
    $("#opcoes").html(` <div class="col-12 col-md-6">
                            <label for="nomeUser">Usuario:</label>
                            <input oninput="mascaranome(this)" type="text" id="nomeUser" name="titleForm" autocomplete="off" 
                                placeholder="${personalInfo[0].username}" />
                        </div>
                        <div class="col-12 col-md-6">
                            <label for="emailUser">E-mail:</label>
                            <input type="text" id="emailUser" name="titleForm" autocomplete="on" oninput="mascaraemail(this)" onblur="validacaoEmail(emailUser)"
                                placeholder="${personalInfo[0].email}" />
                                <div id="msgemail"></div>
                        </div>

                        <div class="col-12 col-md-6">
                            <label for="cpfUser">CPF:</label>
                            <input oninput="mascaracpf(this)" type="text" id="cpfUser" name="titleForm" autocomplete="on"
                                placeholder="${personalInfo[0].cpf}" />
                        </div>
                        <div class="col-12 col-md-6">
                            <label for="telefoneUser">Telefone:</label>
                            <input oninput="mascaratelefone(this)" type="text" id="telefoneUser" name="titleForm" autocomplete="on"
                                placeholder="${personalInfo[0].telefone}" />
                        </div>

                        <div class="col-12 col-md-6">
                            <label for="nomeUser">Nome:</label>
                            <input type="text" id="nomeUser" name="titleForm" autocomplete="on" oninput="mascaranome(this)"
                                placeholder="${personalInfo[0].nome}" />
                        </div>
                        <div class="col-12 col-md-6">
                            <label for="sobrenomeUser">Sobrenome:</label>
                            <input type="text" id="sobrenomeUser" name="titleForm" autocomplete="on" oninput="mascarasobrenome(this)"
                                placeholder="${personalInfo[0].sobrenome}" />
                        </div>
                        <div class="col-12 col-md-6">
                            <label for="idiomasUser">Idiomas:</label>
                            <input type="text" id="idiomasUser" name="titleForm" autocomplete="on"
                                placeholder="${personalInfo[0].idiomas}" />
                        </div>
                        <div class="col-12 col-md-6">
                            <label for="periodoUser">Periodo:</label>
                            <input oninput="mascaraperiodo(this)" type="text" id="periodoUser" name="titleForm" autocomplete="on" oninput="mascaraperiodo(this)"
                                placeholder="${personalInfo[0].periodo}" />
                        </div>
                        <div class="col-12 col-md-6">
                            <label for="linkedinUser">LinkedIn:</label>
                            <input type="text" id="linkedinUser" name="titleForm" autocomplete="on" maxlength="100" oninput="mascaralinkedin(this)"
                                placeholder="${personalInfo[0].linkedin}" />
                        </div>
                        <div class="col-12 col-md-6">
                            <label for="cursoUser">Curso:</label>
                            <input type="text" id="cursoUser" name="titleForm" autocomplete="on"  oninput="mascaracurso(this)"
                                placeholder="${personalInfo[0].curso}" />
                        </div>
                        <div class="col-12">
                            <label for="skillsUser">Skills:</label>
                            <input type="text" id="skillsUser" name="titleForm" autocomplete="on" 
                                placeholder="${personalInfo[0].skills}" />
                        </div>
                        <span onclick="infoUser()">Editar informa????es</span><br>
                        <span onclick="editLog()">Editar login</span>`);
}

////////////////////////////// MASCARAS DE FORMULARIO

function mascaracpf(i){
   
    var v = i.value;
    
    if(isNaN(v[v.length-1])){ // impede entrar outro caractere que n??o seja n??mero
       i.value = v.substring(0, v.length-1);
       return;
    }
    
    i.setAttribute("maxlength", "18");
    if (v.length == 2 || v.length == 6) i.value += ".";
    if (v.length == 10) i.value += "/";
    if (v.length == 15) i.value += "-";
 
}
function mascaratelefone(i){
   
    var v = i.value;
    
    if(isNaN(v[v.length-1])){ // impede entrar outro caractere que n??o seja n??mero
       i.value = v.substring(0, v.length-1);
       return;
    }

    i.setAttribute("maxlength", "13");
    if (v.length == 2) i.value += " ";
    if (v.length == 8) i.value += "-";
 
}
function mascaraperiodo(i){
   
    var v = i.value;
    
    if(isNaN(v[v.length-1])){ // impede entrar outro caractere que n??o seja n??mero
       i.value = v.substring(0, v.length-1);
       return;
    }
    
    i.setAttribute("maxlength", "2"); 
}
function mascaranome(i){  
    i.setAttribute("maxlength", "90");
}
function mascarasobrenome(i){  
    i.setAttribute("maxlength", "90");
}
function mascarasenha(i){  
    i.setAttribute("maxlength", "32");
}
function mascaraemail(i){  
    i.setAttribute("maxlength", "100");
}
function mascarasite(i){  
    i.setAttribute("maxlength", "100");
}
function mascaraperiodo(i){  
    var v = i.value;
    
    if(isNaN(v[v.length-1])){ // impede entrar outro caractere que n??o seja n??mero
       i.value = v.substring(0, v.length-1);
       return;
    }
    i.setAttribute("maxlength", "2");
}
function mascaracurso(i){  
    i.setAttribute("maxlength", "30");
}
function mascaralinkedin(i){  
    i.setAttribute("maxlength", "100");
}
function mascarausuario(i){  
    i.setAttribute("maxlength", "20");
}
function validacaoEmail(field) {
    usuario = field.value.substring(0, field.value.indexOf("@"));
    dominio = field.value.substring(field.value.indexOf("@")+ 1, field.value.length);
    
    if ((usuario.length >=1) &&
        (dominio.length >=3) &&
        (usuario.search("@")==-1) &&
        (dominio.search("@")==-1) &&
        (usuario.search(" ")==-1) &&
        (dominio.search(" ")==-1) &&
        (dominio.search(".")!=-1) &&
        (dominio.indexOf(".") >=1)&&
        (dominio.lastIndexOf(".") < dominio.length - 1)) {
    document.getElementById("msgemail").innerHTML="E-mail v??lido";
    }
    else{
    document.getElementById("msgemail").innerHTML="<font color='red'>E-mail inv??lido </font>";
    alert("E-mail invalido");
    }
}

////////////////////////////// ESTUDANTE INFOS DO FORMULARIO

function infoUser() {
    $("#profile").html(`<form action="http://localhost:6789/estudante" method="post">
                        <div class="col-12 col-md-6">
                                <label for="nomeUser">Usuario:</label>
                                <input oninput="mascaranome(this)" type="text" id="nomeUser" name="usuario" autocomplete="off" 
                                    placeholder="${personalInfo[0].username}" />
                        </div>
                        <div class="col-12 col-md-6">
                                <label for="emailUser">E-mail:</label>
                                <input type="text" id="emailUser" name="email" autocomplete="on" oninput="mascaraemail(this)" onblur="validacaoEmail(emailUser)"
                                    placeholder="${personalInfo[0].email}" />
                                    <div id="msgemail"></div>
                        </div>
                        
                        <div class="col-12 col-md-6">
                                <label for="cpfUser">CPF:</label>
                                <input oninput="mascaracpf(this)" type="text" id="cpfUser" name="cpf" autocomplete="on"
                                    placeholder="${personalInfo[0].cpf}" />
                        </div>
                        <div class="col-12 col-md-6">
                                <label for="telefoneUser">Telefone:</label>
                                <input oninput="mascaratelefone(this)" type="text" id="telefoneUser" name="telefone" autocomplete="on"
                                    placeholder="${personalInfo[0].telefone}" />
                        </div>
                        
                        <div class="col-12 col-md-6">
                                <label for="nomeUser">Nome:</label>
                                <input type="text" id="nomeUser" name="nome" autocomplete="on" oninput="mascaranome(this)"
                                    placeholder="${personalInfo[0].nome}" />
                        </div>
                        <div class="col-12 col-md-6">
                                <label for="sobrenomeUser">Sobrenome:</label>
                                <input type="text" id="sobrenomeUser" name="sobrenome" autocomplete="on" oninput="mascarasobrenome(this)"
                                    placeholder="${personalInfo[0].sobrenome}" />
                        </div>
                        <div class="col-12 col-md-6">
                                <label for="idiomasUser">Idiomas:</label>
                                <input type="text" id="idiomasUser" name="idiomas" autocomplete="on"
                                    placeholder="${personalInfo[0].idiomas}" />
                        </div>
                        <div class="col-12 col-md-6">
                                <label for="periodoUser">Periodo:</label>
                                <input oninput="mascaraperiodo(this)" type="text" id="periodoUser" name="periodo" autocomplete="on" oninput="mascaraperiodo(this)"
                                    placeholder="${personalInfo[0].periodo}" />
                        </div>
                        <div class="col-12 col-md-6">
                                <label for="linkedinUser">LinkedIn:</label>
                                <input type="text" id="linkedinUser" name="linkedin" autocomplete="on" maxlength="100" oninput="mascaralinkedin(this)"
                                    placeholder="${personalInfo[0].linkedin}" />
                        </div>
                        <div class="col-12 col-md-6">
                                <label for="cursoUser">Curso:</label>
                                <input type="text" id="cursoUser" name="curso" autocomplete="on"  oninput="mascaracurso(this)"
                                    placeholder="${personalInfo[0].curso}" />
                        </div>
                        <div class="col-12">
                                <label for="skillsUser">Skills:</label>
                                <input type="text" id="skillsUser" name="skills" autocomplete="on" 
                                    placeholder="${personalInfo[0].skills}" />
                        </div>
                        <button type="button" class="btn btn-success">Importar PDF</button>
                        <input type="submit" class="btn btn-success" value="Salvar"></form>
                        `
    );
}

function montarPerfil() {
    let tipo = "Usu??rio ";
    if (accountType == "userdata")
        tipo += "Comum";

    $("#nome").html(personalInfo[0].nome);
    $("#profile").html(personalInfo[0].desc);
    $("#type").html(tipo);
}

function editLog() {
    $("#profile").html(`<span id="instrucoes"></span>
                        <div class="col-12">
                            <label for="username">Username:</label>
                            <input type="text" id="username" name="usuario" autocomplete="off"  oninput="mascarausuario(this)"
                                placeholder="${personalInfo[0].username}" />
                        </div>
                        <div class="col-12">
                            <label for="password">Senha:</label>
                            <input type="password" id="password" oninput="mascarasenha(this)" name="senha"/> 
                        </div>
                        <div class="col-12">
                            <label for="passConf">Confirmar senha:</label>
                            <input type="password" id="passConf" oninput="mascarasenha(this)" name="senha" />
                        </div>
                        <button type="button" class="btn btn-success" action="http://localhost:6789/estudante" method="post" >Salvar</button>`
    );
}

window.onload = () => {
    if (accountType == "userdata") {
        let valid = true;
        prepCabecalho();
        if (localStorage.getItem("statusLogin") != 1 && localStorage.getItem("statusLogin") != 2) {
            if (sessionStorage.getItem("statusLogin") != 1 && sessionStorage.getItem("statusLogin") != 2) {
                $(".profile").html(`<div class="col-sm-12">
                <p class="loginMsg">Parece que voc?? n??o est?? logado. <br>Tente <a href="../resources/login.html">logar</a>
                </p>
                </div>`);
                valid = false;
            } else {
                accountType = sessionStorage.getItem("statusLogin");
                accountId = sessionStorage.getItem("userId");
            }
        } else {
            accountType = localStorage.getItem("statusLogin");
            accountId = localStorage.getItem("userId");
        }
        if (valid) {
            if (accountType == 2) {
                accountType = "empredata";
            } else { accountType = "userdata"; }
    
            getData();
        }
    }
    
}