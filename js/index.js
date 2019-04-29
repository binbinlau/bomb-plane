// 生成棋盘 10 * 10 棋盘 
function createCheese(className, parentClassName, haveText) {
    var buttonBoxWith = $(className).width();
    var buttonCellWithCount = 10; //设置行的格子个数
    var buttonCellHeightCount = 10; //设置列的格子个数
    // $(parentClassName).attr("style", "height: " + buttonBoxWith.toString() + "px");
    var buttonCellWith = Math.floor(buttonBoxWith / buttonCellWithCount);
    for (let width = 0; width <= buttonCellWithCount; width++) {
        for (let height = 0; height <= buttonCellHeightCount; height++) {
            if (width == 0) {
                if (height == 0)
                    $(className).append(creatSpanCell(height.toString()).css("opacity", 0));
                else
                    $(className).append(creatSpanCell(height.toString()));
            } 
            if (width != 0) {
                if (height == 0) {
                    $(className).append(creatSpanCell(String.fromCharCode(width + 64)));
                } else {
                    $(className).append(creatButtonCell(width, height, buttonCellWith, haveText).html("1"));
                }
            }
        }
        $(className).append("<br>");
    }
    
}

// 边缘标记字母
function creatSpanCell(colIndex) {
    let mySpan = $('<button class="button-cell span-cell" disabled="disabled" > </button>');
    mySpan.text(colIndex);
    return mySpan;
}

function clickMain() {
    alert(this.attr("data-rowindex-colindex"));
}

/* 生成button作为飞机的背景方格 */
function creatButtonCell(rowIndex, colIndex, buttonCellWith, haveText) {
    let myButton = $('<button class="button-cell" type="button" onclick="clickMain()"> </button>');
    myButton.addClass("button-row-" + rowIndex);
    myButton.addClass("button-col-" + colIndex);
    myButton.attr("data-rowIndex", rowIndex);
    myButton.attr("data-colIndex", colIndex);
    myButton.attr("data-rowIndex-colIndex", getkeyForMap(rowIndex, colIndex));
    myButton.attr("title", String.fromCharCode(rowIndex + 64) + "-" + colIndex);
    // myButton.attr("style", "width: " + buttonCellWith.toString() + "px;" + "height: " + buttonCellWith.toString() + "px")
    if (parseInt(haveText) == 1) {
        // myButton.html(String.fromCharCode(rowIndex + 64) + "" + colIndex);
        myButton.addClass("button-second");
    } else {
        myButton.addClass("button-main");
    }
    return myButton;    
}

// 渲染飞机颜色
function renderPlane(position, type) { // 1 表示机身， 2 表示机头
    // console.log("html is : " + $('.button-main[data-rowindex-colindex=' + '"' + position.toString() + '"' + ']').css("background", "red"));
    $('.button-main[data-rowindex-colindex=' + '"' + position.toString() + '"' + ']').css("background", "red");
}

// 随机生成一个飞机
function createPlane() {
    let planeMap = new Map(); // "row-col: 1" 表示该方格中已经有飞机并且是机身； "row-col: 2" 表示该方格中已经有飞机并且是机头
    let randomX = Math.floor(Math.random() * 10) + 1;
    let randomY = Math.floor(Math.random() * 10) + 1;
    let randomDir = Math.floor(Math.random() * 100) % 4; //生成0-3的随机数，代表机头的方向(0: 向上; 1: 向右; 2: 向下; 3: 向左.)
    switch (randomDir) {
        case 0:
            if (randomX > 7) {
                randomX -= 4;
            }
            if (randomY > 8) {
                randomY -= 2;
            }
            if (randomY < 3) {
                randomY += 2
            }
            break;
        case 1:
            if (randomY < 4) {
                randomY += 3;
            }
            if (randomX < 3) {
                randomX += 2;
            }
            if (randomX > 8) {
                randomX -= 2;
            }
            break;
        case 2:
            if (randomX < 4) {
                randomX += 3;
            }
            if (randomY < 3) {
                randomY += 2;
            }
            if (randomY > 8) {
                randomY -= 2;
            }
            break;
        default:
            if (randomY > 7) {
                randomY -= 3;
            }
            if (randomX < 3) {
                randomX += 2;
            }
            if (randomX > 8) {
                randomX -= 2;
            }
            break;
    }
    return getAllByHeader(randomX, randomY, randomDir);
}

//根据机头坐标得到整个飞机，并标记
function getAllByHeader(rowIndex, colIndex, planeDir) {
    let planeMap = new Map();
    planeMap.set(getkeyForMap(rowIndex, colIndex), 2);
    switch (parseInt(planeDir)) {
        case 0:
            planeMap.set(getkeyForMap(rowIndex + 1, colIndex), 1);
            planeMap.set(getkeyForMap(rowIndex + 1, colIndex + 1), 1);
            planeMap.set(getkeyForMap(rowIndex + 1, colIndex - 1), 1);
            planeMap.set(getkeyForMap(rowIndex + 1, colIndex + 2), 1);
            planeMap.set(getkeyForMap(rowIndex + 1, colIndex - 2), 1);
            planeMap.set(getkeyForMap(rowIndex + 2, colIndex), 1);
            planeMap.set(getkeyForMap(rowIndex + 3, colIndex), 1);
            planeMap.set(getkeyForMap(rowIndex + 3, colIndex + 1), 1);
            planeMap.set(getkeyForMap(rowIndex + 3, colIndex - 1), 1);
            break;
        case 2:
            planeMap.set(getkeyForMap(rowIndex - 1 , colIndex - 2), 1);
            planeMap.set(getkeyForMap(rowIndex - 1, colIndex - 1), 1);
            planeMap.set(getkeyForMap(rowIndex - 1, colIndex), 1);
            planeMap.set(getkeyForMap(rowIndex - 1, colIndex + 1), 1);
            planeMap.set(getkeyForMap(rowIndex - 1, colIndex + 2), 1);
            planeMap.set(getkeyForMap(rowIndex - 2, colIndex), 1);
            planeMap.set(getkeyForMap(rowIndex - 3, colIndex - 1), 1);
            planeMap.set(getkeyForMap(rowIndex - 3, colIndex), 1);
            planeMap.set(getkeyForMap(rowIndex - 3, colIndex + 1), 1);
            break;
        case 1:
            planeMap.set(getkeyForMap(rowIndex, colIndex - 1), 1);
            planeMap.set(getkeyForMap(rowIndex, colIndex - 2), 1);
            planeMap.set(getkeyForMap(rowIndex, colIndex - 3), 1);
            planeMap.set(getkeyForMap(rowIndex - 1, colIndex - 1), 1);
            planeMap.set(getkeyForMap(rowIndex - 1, colIndex - 3), 1);
            planeMap.set(getkeyForMap(rowIndex - 2, colIndex - 1), 1);
            planeMap.set(getkeyForMap(rowIndex + 1, colIndex - 1), 1);
            planeMap.set(getkeyForMap(rowIndex + 1, colIndex - 3), 1);
            planeMap.set(getkeyForMap(rowIndex + 2, colIndex - 1), 1);
            break;
        default:
            planeMap.set(getkeyForMap(rowIndex, colIndex + 1), 1);
            planeMap.set(getkeyForMap(rowIndex, colIndex + 2), 1);
            planeMap.set(getkeyForMap(rowIndex, colIndex + 3), 1);
            planeMap.set(getkeyForMap(rowIndex - 1, colIndex + 1), 1);
            planeMap.set(getkeyForMap(rowIndex - 1, colIndex + 3), 1);
            planeMap.set(getkeyForMap(rowIndex - 2, colIndex + 1), 1);
            planeMap.set(getkeyForMap(rowIndex + 1, colIndex + 1), 1);
            planeMap.set(getkeyForMap(rowIndex + 1, colIndex + 3), 1);
            planeMap.set(getkeyForMap(rowIndex + 2, colIndex + 1), 1);
            console.log("planeMap0 : " + planeMap.size);
            break;
    }
    return planeMap;
}

//拼接Map中的key值，标记已有飞机坐标
function getkeyForMap(rowIndex, colIndex) {
    return rowIndex.toString() + "-" + colIndex.toString();
}