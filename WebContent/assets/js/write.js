window.onload = function () {
    // $("#file").on('change',function(){
    //     var fileName = $("#file").val();
    //     $(".upload-name").val(fileName);
    // });
    
    document.getElementById("file").addEventListener("change", function () {

        document.querySelector(".upload-name").value = this.value;
    })
    
}