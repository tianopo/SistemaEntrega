$(document).ready(function () {
    // Máscara para o CPF
    $('#cpf').mask('000.000.000-00', { reverse: true, placeholder: '___.___.___-__' });

    // Máscara para o Telefone
    $('#telefone').mask('(00) 0000-00009', { placeholder: '(__) _____-____' });

    // Restrição do campo Nome (somente letras e até 255 caracteres) com placeholder
    $('#nome').attr('placeholder', 'Maria Silva');
    $('#nome').on('input', function () {
        var sanitized = $(this).val().replace(/[^a-zA-Z\s]/g, '').substring(0, 255);
        $(this).val(sanitized);
    });

    // Restrição do campo Logradouro (até 255 caracteres) com placeholder
    $('#logradouro').attr('placeholder', 'Rua Acre - Cidade São José, Rio Preto');
    $('#logradouro').on('input', function () {
        var sanitized = $(this).val().substring(0, 255);
        $(this).val(sanitized);
    });
    
    // Máscara para o CEP (8 caracteres)
    $('#cep').mask('00.000-000', { placeholder: '__.___-___' });
    
    // Máscara para o Número
    $('#numero').mask('0#', { placeholder: '3231' });

    // Restrição do campo Complemento (até 255 caracteres) com placeholder
    $('#complemento').attr('placeholder', 'bl 5 apto 4');
    $('#complemento').on('input', function () {
        var sanitized = $(this).val().substring(0, 255);
        $(this).val(sanitized);
    });
});
