const list = document.querySelectorAll(".trending-item");

function addColor() {
    for(let i = 0 ; i < list.length ; i++){
        if(i == 0){
            list[i].classList.add("top-1");
        }
        else if (i == 1) {
            list[i].classList.add("top-2");
        }
        else if (i == 2) {
            list[i].classList.add("top-3");
        }
        else{
            list[i].classList.add("under-3")
        }
    }
}

addColor();