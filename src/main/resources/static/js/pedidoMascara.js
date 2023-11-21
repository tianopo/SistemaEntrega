$(document).ready(function () {
    // Máscara para o CEP
    $('#cep').mask('00.000-000', { placeholder: 'XX.XXX-XXX' });

    // Máscara para o Número
    $('#numero').mask('000', { placeholder: 'XXX' });

    // Adicionando placeholders
    $('#nome').attr('placeholder', 'Digite o nome');
    $('#logradouro').attr('placeholder', 'Digite o endereço');
    $('#descricao').attr('placeholder', 'Digite a descrição');

    // Restrição do campo Descrição (até 255 caracteres)
    $('#descricao').on('input', function () {
        var sanitized = $(this).val().substring(0, 255);
        $(this).val(sanitized);
    });
});