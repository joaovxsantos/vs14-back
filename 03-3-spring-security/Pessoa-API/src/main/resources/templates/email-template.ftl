<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Java Mail</title>
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td align="center" valign="top" bgcolor="#838383"
            style="background-color: #838383;"><br> <br>
            <table width="600" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td align="center" valign="top" bgcolor="#d3be6c"
                        style="background-color: #d3be6c; font-family: Arial, Helvetica, sans-serif; font-size: 13px; color: #000000; padding: 0px 15px 10px 15px;">

                        <div style="font-size: 48px; color:blue;">
                            <b>Email de Criação</b>
                        </div>

                        <div style="font-size: 24px; color: #555100;">
                            <br> Olá! ${nome} Cadastramos seu novo endereço :) </b> <br>
                        </div>
                        <div>
                            <br> <br> <b>Bem vindo ${nome}!</b>
                            <br>
                            <h1>Seus dados de cadastro: </h1>
                            <ul>
                                <li>Nome: ${nome}</li>
                                <li>Data de nascimento: ${aniversario}</li>
                                <li>CPF: ${cpf}</li>
                            </ul>
                        </div>
                    </td>
                </tr>
            </table> <br> <br></td>
    </tr>
</table>
</body>
</html>