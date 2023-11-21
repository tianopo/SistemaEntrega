$(document).ready(function () {
    // Máscara para o CPF
    $('#cpf').mask('000.000.000-00', { reverse: true, placeholder: '___.___.___-__' });

    // Máscara para a Data de Nascimento
    $('#nascimento').mask('00/00/0000', { placeholder: '__/__/____' });

    // Máscara para o Telefone
    $('#telefone').mask('(00) 0000-00009', { placeholder: '(__) _____-____' });

    // Restrição do campo Nome (somente letras e até 255 caracteres)
    $('#nome').on('input', function () {
      var sanitized = $(this).val().replace(/[^a-zA-Z\s]/g, '').substring(0, 255);
      $(this).val(sanitized);
    });

    // Restrição do campo Moto (até 100 caracteres)
    $('#moto').attr('placeholder', 'Honda Biz 110i');
    $('#moto').on('input', function () {
      var sanitized = $(this).val().substring(0, 100);
      $(this).val(sanitized);
    });

    // Restrição do campo Placa (até 7 caracteres)
    $('#placa').attr('placeholder', 'XXXXXXX');
    $('#placa').on('input', function () {
      var sanitized = $(this).val().substring(0, 7);
      $(this).val(sanitized.toUpperCase());
    });
  });


