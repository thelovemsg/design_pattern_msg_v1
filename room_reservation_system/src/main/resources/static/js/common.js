function fetchData(url, params, updateTableCallback, updatePaginationCallback) {
    $.ajax({
        url: url,
        type: 'GET',
        data: params,
        dataType: 'json',
        success: function(data) {
            if (data && data.content) {
                updateTableCallback(data.content);
                updatePaginationCallback(data);
            } else {
                console.error('No content available');
            }
        },
        error: function(xhr, status, error) {
            console.error('An error occurred:', error);
        }
    });
}

// 페이징 컨트롤 생성 함수
function createPagination(paginationData, fetchDataFunction) {
    const pagination = $('#pagination');
    pagination.empty(); // 기존 페이지네이션을 초기화
    // 페이지네이션 버튼 생성
    for (let i = 0; i < paginationData.totalPages; i++) {
        const li = $('<li>').addClass('page-item').appendTo(pagination);
        if (i === paginationData.number) {
            li.addClass('active'); // 현재 페이지 활성화
        }
        $('<a>').addClass('page-link')
            .attr('href', '#')
            .text(i + 1)
            .appendTo(li)
            .click((e) => {
                e.preventDefault();
                fetchDataFunction(i); // 클릭된 페이지 데이터 로드 함수
            });
    }
}

// 페이지 버튼 클릭 이벤트를 처리하는 함수
function attachPageButtonEvents(fetchDataFunction) {
    $('#pagination').on('click', 'a.page-link', function(e) {
        e.preventDefault();
        const page = $(this).text() - 1;
        fetchDataFunction(page);
    });
}