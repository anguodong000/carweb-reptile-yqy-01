function renderPageItem(totalPageNums,playes,edges,currentPage) {
    //debugger;
    $ul = $('<ul class="pagination pull-right" style="margin:-3px 0;">');
    var start = 1;
    var end = totalPageNums;
    if(playes % 2){
        //playes是奇数
        start = currentPage - Math.floor(playes / 2);
        end = currentPage + Math.floor(playes / 2);
    }else{
        //playes是偶数
        start = currentPage - (playes / 2 - 1);
        end = currentPage + playes / 2;
    }
    if (start <= edges + 1) {
        start = 1;
        if (end < playes && playes<totalPageNums) {
            end = playes;
        }
    }else{
        for (var i = 1; i <= edges; i++) {
            $ul.append(renderItem(i,currentPage));
        }
        $ul.append('<li class="paginate_button previous"><span>...</span></li>');
    }
    if (end < totalPageNums - edges) {
        for (var i = start; i <= end; i++) {
            $ul.append(renderItem(i,currentPage));
        }
        $ul.append('<li class="paginate_button previous"><span>...</span></li>');
        for (var i = totalPageNums - edges + 1; i <= totalPageNums; i++) {
            $ul.append(renderItem(i,currentPage));
        }
    }else{
        end = totalPageNums;
        /*if(start>totalPageNums-playes+1){
            start = totalPageNums-playes+1
        }*/
        for (var i = start; i <= end; i++) {
            $ul.append(renderItem(i));
        }
    }
    $ul.prepend(renderPrevItem(currentPage));
    $ul.append(renderNextItem(currentPage,totalPageNums));
    $('#editable_paginate').empty().append($ul);
}

function renderItem(i,currentPage) {
    //debugger;
    $item = $('<li class="paginate_button previous" ><a href="javascript:carPartList('+i+')">'+i+'</a></li>');
    if (i == currentPage) {
        $item.addClass('active');
    }
    $item.on('click', (function (num) {
        return function () {
            currentPage = num;
            renderPageItem(currentPage);
        }
    })(i));
    return $item;
}

function renderPrevItem(currentPage) {
    //debugger;
    $prev = $('<li class="paginate_button previous"><a href="javascript:carPartList('+currentPage+')" >上一页</a></li>');
    if (currentPage == 1) {
        $prev.addClass('disabled');
    } else {
        $prev.on('click', function () {
            currentPage = currentPage - 1;
            renderPageItem(currentPage);
        })
    }
    return $prev;
}

function renderNextItem(currentPage,totalPageNums) {
    //debugger;
    $next = $('<li class="paginate_button previous"><a href="javascript:carPartList('+currentPage+')" >下一页</a></li>');
    if (currentPage == totalPageNums) {
        $next.addClass('disabled');
    } else {
        $next.on('click', function () {
            currentPage = currentPage + 1;
            renderPageItem(currentPage);
        })
    }
    return $next;
}