var board = {
    init : function () {
        var _this = this;
        
        //글쓰기
		$('#btn_board_write').on('click', function(){
			location.href='/boardWrite';	
		});
		
		//글쓰기
		$('#btn_board_list').on('click', function(){
			location.href='/boardList';	
		});
		
    },
    save : function () {
    	
        		
    }

};

board.init();


