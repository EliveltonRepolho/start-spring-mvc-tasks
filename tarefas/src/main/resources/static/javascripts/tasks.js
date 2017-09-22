var Utils = Utils || {};

Utils.MaskDate = (function() {

    function MaskDate() {
        this.inputDate = $('.js-date');

        this.tooltips = {
            today: 'Ir para hoje',
            clear: 'Limpar seleção',
            close: 'Fechar',
            selectMonth: 'Selecionar mês',
            prevMonth: 'Mês anterior',
            nextMonth: 'Próximo mês',
            selectYear: 'Selecionar ano',
            prevYear: 'Próximo ano',
            nextYear: 'Ano anterior',
        }
    }

    MaskDate.prototype.enable = function() {
        this.inputDate.mask('00/00/0000');
        this.inputDate.datetimepicker({
            toolbarPlacement:'top',
            showClear: true,
            showTodayButton : true,
            showClose: true,
            allowInputToggle: true,
            format: 'DD/MM/YYYY',
            tooltips: this.tooltips
        });
    }

    return MaskDate;

}());

$(function() {
	var maskDate = new Utils.MaskDate();
    maskDate.enable();
});
