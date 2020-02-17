
$(function () {
	
	
	
    $(document).keydown(function (event) {
        var keyCode = (event.keyCode ? event.keyCode : event.which);
        if (keyCode == 81) {
            $('.search_report').trigger('click');
        }

        if (keyCode == 27) {
            $('.close_search_pop, .no_logout').trigger('click');
        }
    });

    $('.search_report').on('click', function () {
        setTimeout(function () {
            $('.search_pop').addClass('called');
        }, 100);
        overlayOn();
    });

    $('.close_search_pop').on('click', function () {
        setTimeout(function () {
            overlayOff();
        }, 100);
        $('.search_pop').removeClass('called');
    });

    $('.logout').click(function () {
        $('.confirm_logout').addClass('called');
        overlayOn();

    });

    $('.no_logout').click(function () {
        $('.confirm_logout').removeClass('called');
        overlayOff();
    });

    $(window).resize(function () {
        var field = $(document.activeElement);
        if (field.is('.hasDatepicker')) {
            field.datepicker('hide').datepicker('show');
        }
    });


    $('form').on('reset', function () {
        $('.shortcode, .keyword').hide();
        $('#default_shortcode, #default_keyword').show();
    });
    
    $('.compare_button').on('click', function () {
       $('.comparison_year_wrap').addClass('called');
    });

    $('.year_holder').on('click', function () {
        var buttonWidth = $(this).outerWidth();
        $('.item_sorter').width(buttonWidth);
        
        $(this).addClass('active');
        $('.item_sorter').toggle();
        $('.dropdown_download').hide();
        $('.download_report_button').removeClass('active');
    });

    $('.download_report_button').on('click', function () {
        var buttonWidth = $(this).outerWidth();
        $('.dropdown_download').width(buttonWidth);

        $(this).toggleClass('active');
        $(this).next().toggle(0);
        $(".item_sorter").hide();
        $('.year_holder').removeClass('active');
    });

    $(document).click(function () {
        $(".dropdown_download, .item_sorter").hide();
        $('.download_report_button, .year_holder').removeClass('active');
    });

    /* Clicks within the dropdown won't make
     it past the dropdown itself */
    $(".dropdown_download, .download_report_button, .year_holder").click(function (e) {
        e.stopPropagation();
    });




    // search criteria COUNTRY select on change
    $('#country_select').on('change', function () {
        if ($(this).val() === '0') {
            // if country selected option is number 1
            resetKeywordFilter();
            resetShortcodeFilter();
            $('.shortcode').hide();
            $('.keyword').hide();
            $('#default_shortcode').show();
            $('#default_keyword').show();

        }
        if ($(this).val() === 'my') {
            $('#default_shortcode').hide();
            $('.shortcode').hide();
            $('#my_shortcode').show();
        }

        if ($(this).val() === 'th') {
            $('#default_shortcode').hide();
            $('.shortcode').hide();
            $('#th_shortcode').show();
        }

        if ($(this).val() === 'vn') {
            $('#default_shortcode').hide();
            $('.shortcode').hide();
            $('#vn_shortcode').show();
        }


    });

    // search criteria shortcode select on change
    $('.shortcode').on('change', function () {
        var value = $(':selected', this).attr('value');
        console.log('shortcode changed ' + value);

        if ($(this).val() === '0') {
            resetKeywordFilter();
            $('.keyword').hide();
            $('#default_keyword').show();
        } else if ($(this).val() === value) {
            resetKeywordFilter();
            $('.keyword').hide();
            $('.keyword[id=' + value + ']').show();
            $('#default_keyword').hide();
        }
    });


    $('<span class="version"><b>Version</b> 1.0</div>').appendTo('footer div:nth-of-type(2)');
});
function resetKeywordFilter() {
    $('.keyword').prop('selectedIndex', 0);
}

function resetShortcodeFilter() {
    $('.shortcode').prop('selectedIndex', 0);
}
function overlayOn() {
    $('.overlay').addClass('called');
    //$('body').addClass('noscroll');
}

function overlayOff() {
    $('.overlay').removeClass('called');
    //$('body').removeClass('noscroll');
}

$(".previewable").hover(function () { // on mouse enter element
        var pageUrl = $(this).text(); // grab URL via text inside the element
        var position = $(this).offset(); // ignore this
        $('body').append($("<div class='previewcontainer'><iframe frameborder='0' width='320' height='640' scrolling='no' src='"+ pageUrl +"'></iframe></div>")); // insert iframe element
       
        //$(".previewcontainer").css("left", position.left - 0).css("top", position.top + 30);
        $(".previewcontainer").show(function(){ // show iframe element
            $(this).find('iframe').addClass('called'); // add awesome animation
        });
    }, function () { // on mouse leave
        $('body').find(".previewcontainer").remove(); // remove the iframe
    });
