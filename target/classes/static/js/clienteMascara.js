$(document).ready(function () {
    // Máscara para o CPF
    $('#cpf').mask('000.000.000-00', { reverse: true, placeholder: '___.___.___-__' });

    // Máscara para o Telefone
    $('#telefone').mask('(00) 0000-00009', { placeholder: '(__) _____-____' });

    // Máscara para o Número
    $('#numero').mask('0#');

    // Restrição do campo Nome (somente letras e até 255 caracteres)
    $('#nome').on('input', function () {
        var sanitized = $(this).val().replace(/[^a-zA-Z\s]/g, '').substring(0, 255);
        $(this).val(sanitized);
    });

    // Restrição do campo Logradouro (até 255 caracteres)
    $('#logradouro').on('input', function () {
        var sanitized = $(this).val().substring(0, 255);
        $(this).val(sanitized);
    });

    // Restrição do campo Complemento (até 255 caracteres)
    $('#complemento').on('input', function () {
        var sanitized = $(this).val().substring(0, 255);
        $(this).val(sanitized);
    });
});
