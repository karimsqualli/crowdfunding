(function($) {
    'use strict';

    // All JavaScript pluging initialization code here

    //mobile meanmenu
    $('.mobile-menu').meanmenu();

    // Portfolio
    $('.portfolio-area').imagesLoaded(function() {
        var $grid = $('.portfolio-container').isotope({
            itemSelector: '.portfolio-item',
            percentPosition: true,
        })

        // Portfolio filtering activation
        $('.protfolio-filter li a').on('click', function() {
            var filterValue = $(this).attr('data-filter');
            $grid.isotope({ filter: filterValue });
        });

        // Filter menu active class addition  
        $('.protfolio-filter li').on('click', function(event) {
            $(this).siblings('.active').removeClass('active');
            $(this).addClass('active');
            event.preventDefault();
        });

        // LOAD MORE BUTTON FOR PORTFOLIO
        $('.load-more-btn').on('click', function(event) {
            $('.portfolio-item').removeClass('hidden');
            var $grid = $('.portfolio-container').isotope();
            $(this).hide();
            $('.portfolio-area .load-more').append('<a class="btn btn-default load-more-btn" href="javascript:void(0)">No More Items</a>')
            event.preventDefault();
        });
    });

    //Slider
    $('.slider-wrapper').slick({
        dots: false,
        arrows: true,
        autoPlay: true,
        speed: 300,
        autoPlaySpeed: 3000,
        infinite: true,
        fade: true,
        easing: 'linear',
        slidesToShow: 1,
        slidesToScroll: 1,
        responsive: [{
            breakpoint: 1024,
            settings: {
                dots: true,
                arrows: false
            }
        }, ]
    });

    //Donet slider
    $('.donate-feature-list').slick({
        dots: false,
        arrows: true,
        autoPlay: true,
        speed: 500,
        autoPlaySpeed: 3000,
        infinite: true,
        slidesToShow: 1,
        slidesToScroll: 1,
        responsive: [{
            breakpoint: 1024,
            settings: {

            }
        }, ]
    });

    //Volunteer slider
    $('.volunteer-member-list').slick({
        dots: false,
        arrows: true,
        autoPlay: false,
        speed: 500,
        autoPlaySpeed: 3000,
        infinite: true,
        slidesToShow: 3,
        slidesToScroll: 3,
        responsive: [{
            breakpoint: 767,
            settings: {
                slidesToShow: 1
            }
        }, ]
    });

    // Testimonial slider
    $('.testimonial-wrapper').slick({
        autoplay: true,
        dots: false,
        infinite: true,
        speed: 300,
        slidesToShow: 3,
        adaptiveHeight: false,
        arrows: true,
        responsive: [{
            breakpoint: 992,
            settings: {
                slidesToShow: 2
            }
        }, {
            breakpoint: 767,
            settings: {
                slidesToShow: 1
            }
        }]
    });

    // Latest News slider
    $('.latest-news-wrapper').slick({
        autoplay: true,
        dots: true,
        infinite: true,
        speed: 300,
        slidesToShow: 1,
        adaptiveHeight: false,
        arrows: false,
    });

    // sponsor slider
    $('.sponsor-thumbnail-wrapper').slick({
        autoplay: true,
        dots: false,
        infinite: true,
        speed: 300,
        slidesToShow: 5,
        adaptiveHeight: false,
        arrows: false,
        responsive: [{
            breakpoint: 1169,
            settings: {
                slidesToShow: 4
            }
        }, {
            breakpoint: 992,
            settings: {
                slidesToShow: 3
            }
        }, {
            breakpoint: 767,
            settings: {
                slidesToShow: 1
            }
        }]
    });


    /*------------------------------------------------
     Magnificpopup for Portfolio gallery section
    -------------------------------------------------- */
    $('.view-gallery').magnificPopup({
        type: 'image',
        removalDelay: 300,
        mainClass: 'mfp-no-margins mfp-with-zoom',
        gallery: {
            enabled: true,
        },
        image: {
            tError: '<a href="%url%">The image #%curr%</a> could not be loaded.',
            titleSrc: function(item) {
                return item.el.attr('data-title');
            }
        }
    });

    // WoW js init
    new WOW().init();

    // Counetrup
    $('.counter').counterUp({
        delay: 10,
        time: 1000
    });

    // Calendar
    $("#my-calendar").zabuto_calendar({
        language: "en",
        today: true,
        weekstartson: 0
    });

    // COUNTDOWN TIMER
    $('.countdown').downCount({
        date: '12/30/2018 05:00:00',
        offset: +1
    });


    /*-------------------------------------------
      SCROLL TO TOP BUTTON
    ---------------------------------------------*/
    $('body').append('<a id="back-to-top" class="to-top-btn" href="#"><i class="fa fa-angle-up"></i></a>');
    if ($('#back-to-top').length) {
        var scrollTrigger = 100, // px
            backToTop = function() {
                var scrollTop = $(window).scrollTop();
                if (scrollTop > scrollTrigger) {
                    $('#back-to-top').addClass('to-top-show');
                } else {
                    $('#back-to-top').removeClass('to-top-show');
                }
            };
        backToTop();
        $(window).on('scroll', function() {
            backToTop();
        });
        $('#back-to-top').on('click', function(e) {
            e.preventDefault();
            $('html,body').animate({
                scrollTop: 0
            }, 1250);
        });
    };

    // Overlay search pagination-area
    $('.search-toggle-button').on('click', function(e) {
        $('.full-width-search-wrapper').toggleClass('search-wrapper-show');
        e.preventDefault();
    });
    $('.search-closer').on('click', function() {
        $('.full-width-search-wrapper').toggleClass('search-wrapper-show')
    });

    $("#sticky-header").sticky({
        topSpacing:0,
        className: 'is_stuck',
        zIndex: 9
    });


})(jQuery);