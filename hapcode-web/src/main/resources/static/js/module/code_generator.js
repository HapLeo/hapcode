var CodeGenerator = {}

CodeGenerator.genJavaFile = function () {

    $('#submit').click(function () {
        var tableName = $('#tableName').val();
        var bizModuleName = $('#bizModuleName').val();
        var author = $('#author').val();
        if (tableName == 'undefined' || tableName == '') {
            alert("表名称不能为空！");
            return;
        }
        if (bizModuleName == 'undefined' || bizModuleName == '') {
            alert("模块名称不能为空！");
            return;
        }
        $.ajax({
            url: '/hapcode/codingAll',
            method: 'post',
            data: {
                'tableName': tableName,
                'bizModuleName': bizModuleName,
                'author': author,
            },
            success: function () {
                alert("执行成功！");
            },
            error: function (result) {
                alert(result);
            }
        });
    });


}

CodeGenerator.genApiFile = function () {

    $('#submitApiBtn').click(function () {
        var tableNames = $('#tableNames').val();
        var destPath = $('#destPath').val();
        var desc = $('#desc').val();
        var url = $('#url').val();
        var dtoAbPath = $('#dtoAbPath').val();
        var responseStr = $('#responseStr').val();

        $.ajax({
            url: '/hapcode/codingApi',
            method: 'post',
            data: {
                'tableNames': tableNames,
                'destPath': destPath,
                'desc': desc,
                'url': url,
                'dtoAbPath': dtoAbPath,
                'responseStr': responseStr
            },
            success: function () {
                console.log("执行成功！");
            },
            error: function (result) {
                alert(result);
            }
        });
    });

}

$(function () {

    CodeGenerator.genJavaFile();
    CodeGenerator.genApiFile();

    $('#desc').change(function () {

        var destPath = "D:\\\\" + $('#desc').val() + "API.md";
        $('#destPath').val(destPath);
    });
})