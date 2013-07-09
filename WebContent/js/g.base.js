( function(jQuery) {
	jQuery.fn.hoverForIE6 = function(option) {
		var s = jQuery.extend( {
			current : "hover",
			delay : 10
		}, option || {});
		jQuery.each(this, function() {
			var timer1 = null, timer2 = null, flag = false;
			jQuery(this).bind("mouseover", function() {
				if (flag) {
					clearTimeout(timer2);
				} else {
					var _this = jQuery(this);
					timer1 = setTimeout( function() {
						_this.addClass(s.current);
						flag = true;
					}, s.delay);
				}
			}).bind("mouseout", function() {
				if (flag) {
					var _this = jQuery(this);
					timer2 = setTimeout( function() {
						_this.removeClass(s.current);
						flag = false;
					}, s.delay);
				} else {
					clearTimeout(timer1);
				}
			})
		})
	}
})(jQuery);