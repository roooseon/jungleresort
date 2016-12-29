var k = b();
k.d;


function a() {
	var b = 1;
	return function() {
		b++;
		return b;
	}
}

var k = a();
console.log(k());