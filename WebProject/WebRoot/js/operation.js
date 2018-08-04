/**
 * Created by asus on 2018/7/4.
 */

window.onload = function () {

}


function getXHR() {
    var xmlhttp;
    if (window.XMLHttpRequest){
        xmlhttp=new XMLHttpRequest();
    }else{
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    return xmlhttp;
}

function deleteThing(component, comm_id, baseUrl) {
    var container = component.parentNode;
    var url = baseUrl + "?id=" + comm_id;
    var xmlhttp=getXHR();
    xmlhttp.onreadystatechange=function () {
        if (xmlhttp.readyState==4&&xmlhttp.status==200){
            var res=xmlhttp.responseText;
            var res=eval('('+res+')');
            if (res.msg=="success"){
                var p = container.parentNode;
                p.removeChild(container);
            }
        }
    }
    xmlhttp.open("POST",url,true);
    xmlhttp.send();
}

function deleteFriend(component,comm_id) {
    deleteThing(component,comm_id,"../servlet/DelFriendServlet");
    return false;
}
