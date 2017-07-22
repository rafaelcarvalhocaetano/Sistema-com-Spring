$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event){
	
	var button = $(event.relatedTarget);
	
	var codigoTitulo = button.data('codigo');
	var descricaoTitulo = button.data('descricao');
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	if (!action.endsWith('/')) {
		action += '/';
	}
	form.attr('action', action + codigoTitulo);
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir o título <strong>' + descricaoTitulo + '</strong>?');
	
});

//inicializa o tooltip do bootstrap após a pagina ser inicializada
$(function name() {
	$('[rel= "tooltip"]').tooltip();
	
	//configurando o compo de valor com jquery maskMoney
	$('.js-currency').maskMoney({
		decimal: ',',
		thousands: '.',
		allowZero: true
	});
	
	//ação do click do botao receber
	$('.js-atualizar-status').on('click', function(event){
		
		//informando para não fazer o corportamento padrão do link
		event.preventDefault();
		
		var botaoReceber = $(event.currentTarget);
		var urlReceber = botaoReceber.attr('href');
		
		console.log('url receber', urlReceber);
	});
});

