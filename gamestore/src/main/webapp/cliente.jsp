<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <title>Game Store</title>

        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/style.css">
    </head>
    <body>

        <div class="wrapper">
                <div style="margin-bottom: 15px;">
                    <button type="button" class="btn btn-secondary btn-lg" id="liberacadastro">Cadastro</button>
                    <button type="button" class="btn btn-secondary btn-lg" id="liberapesquisa">Listar</button>
                </div>

                <div id="cadastro">
                    <form action="
                          <c:choose>
                              <c:when test="${cliente != null}">
                                  ${pageContext.request.contextPath}/AlterarClienteServlet?id=${cliente.id}
                              </c:when>
                              <c:otherwise>
                                  ${pageContext.request.contextPath}/ClienteServlet
                              </c:otherwise>
                          </c:choose>
                          " method="post">
                        <div class="form-row">
                            <div class="form-group col-md-8">
                                <label for="servico">Nome</label>
                                <input type="text" class="form-control" id="servico" name="nome" value="${cliente.nome}" >
                            </div>

                            <div class="form-group col-md-4">
                                <label for="calendario">Data de Nascimento</label>
                                <input type="text" class="form-control" id="calendario" name="dtnascimento" value="${cliente.dataNascimentoStr}" >
                            </div> 
                        </div>

                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="cpf">CPF</label>
                                <input type="text" class="form-control" id="cpf" name="cpf" value="${cliente.cpf}" >
                            </div>

                            <div class="form-group col-md-6">
                                <label for="inputState">Sexo</label>
                                <select id="inputState" class="form-control" name="sexo" value="${cliente.sexo}">
                                    <option>Selecione...</option>
                                    <option value="M"
                                            <c:if test="${cliente.sexo == 'M'.charAt(0)}">selected</c:if>
                                            >Masculino</option>
                                    <option value="F" <c:if test="${cliente.sexo == 'F'.charAt(0)}">selected</c:if>>Feminino</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-row">

                            <div class="form-group col-md-6">
                                <label for="rg">RG</label>
                                <input type="text" class="form-control" id="rg" name="rg" value="${cliente.rg}">
                            </div>

                            z

                        </div>

                        <div class="form-row">
                            <div class="form-group col-md-3">
                                <label for="telefone">Telefone</label>
                                <input type="text" class="form-control" id="telefone" name="telefone" value="${cliente.telefone}">
                            </div>
                            
                            <div class="form-group col-md-6">
                                <label for="endereco">Endereço</label>
                                <input type="text" class="form-control" id="endereco" name="endereco" value="${cliente.endereco}">
                            </div>

                            

                        </div>

                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="email">Email</label>
                                <input type="text" class="form-control" id="email" name="email" value="${cliente.email}">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="senha">Senha</label>
                                <input type="password" class="form-control" id="senha" name="senha" value="${cliente.senha}">
                            </div>

                        </div>

                        <div class="form-row">
                            <div class="form-group col-md-4">
                            </div>
                            <div class="form-group col-md-4 text-center">
                                <button type="submit" class="btn btn-primary btn-lg btn-block">Cadastrar</button>
                            </div>
                            <div class="form-group col-md-4">
                            </div>
                        </div>

                    </form>

                </div>

                <div id="pesquisa" style="display: none">

                    <table class="table" id="tabelaservicos">
                        <thead>
                            <tr>
                                <th scope="col">Id</th>
                                <th scope="col">Nome</th>
                                <th scope="col">CPF</th>
                                <th scope="col">RG</th>
                                <th scope="col">Data Nascimento</th>
                                <th scope="col">Telefone</th>
                                <th scope="col">Email</th>
                                <th scope="col">Endereço</th>
<!--                                <th scope="col">Filial</th>-->
                                <th scope="col">Editar</th>
                                <th scope="col">Excluir</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${clientes}" var="c">
                                <tr>
                                    <td scope="row"><c:out value="${c.id}" /></td>
                                    <td><c:out value="${c.nome}" /></td>
                                    <td><c:out value="${c.cpf}" /></td>
                                    <td><c:out value="${c.rg}" /></td>
                                    <td><c:out value="${c.dataNascimento}" /></td>
                                    <td><c:out value="${c.telefone}" /></td>
                                    <td><c:out value="${c.email}" /></td>
                                    <td><c:out value="${c.endereco}" /></td>

                                    <td><a href="${pageContext.request.contextPath}/AlterarClienteServlet?id=${c.id}"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>
                                    <td><a href="${pageContext.request.contextPath}/ExcluirClienteServlet?id=${c.id}"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>


                </div>
            </div>
        </div>

        <script src="assets/js/jquery-1.12.0.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="assets/css/jquery.dataTables.css">
        <script type="text/javascript" charset="utf8" src="assets/js/jquery.dataTables.js"></script>
        <script src="assets/js/jquery-ui.min.js"></script>
        <link rel="stylesheet" href="assets/css/jquery-ui.css" />


        <script type="text/javascript">
            $(document).ready(function () {
                //$("#calendario").datepicker();
                $( "#calendario" ).datepicker( "option", "dateFormat", "dd/mm/yy");
                $('#tabelaservicos').DataTable({
                    "language": {
                    "lengthMenu": "Mostrando _MENU_ resultados por página",
                    "zeroRecords": "Nada encontrado - desculpe.",
                    "infoEmpty": "Não há dados para mostrar",
                    "infoFiltered": "(filtrado no total de _MAX_ resultados)",
                    "search": "Procurar: ",
                    "info": "Mostrando página _PAGE_ de _PAGES_",
                        "paginate": {
                            "first": "Primeiro",
                            "last": "Último",
                            "next": "Próximo",
                            "previous": "Anterior"
                        },
                    }
                });
            });
            $("#liberacadastro").on("click", function () {
                $("#cadastro").show();
                $("#pesquisa").hide();
            });
            $("#liberapesquisa").on("click", function () {
                $("#cadastro").hide();
                $("#pesquisa").show();
            });
        </script>
    </body>
</html>