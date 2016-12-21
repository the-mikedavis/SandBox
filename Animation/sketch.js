var colorArray = [];
function setup() {
	createCanvas(300,300);
	background(250);
	stroke(255,0,0);
	noFill();
	colorArray = [
			color(220,20,60),
			color(255,0,0),
			color(255,165,0),
			color(255,128,128),
			color(255,255,0)
		];
}

function draw() {
	stroke(255,0,0);
	strokeWeight(2);
	for (var count = 0; count < 5; count++){
		stroke(colorArray[count]);
		arc(width/2, height/2, width/2 - count, height/2 + count, 9*PI/16, 7*PI/16);
	}
}