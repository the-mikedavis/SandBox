function width () { return window.innerWidth; }
function height () { return window.innerHeight; }

var svg = d3.select('svg')
    .attr('width', width())
    .attr('height', height())
    .style('background-color', '#444');

window.addEventListener('resize', function () {
    d3.select('svg')
        .attr('width', width())
        .attr('height', height());
    d3.select('circle')
        .attr('cx', width() / 2)
        .attr('cy', height() / 2);
    d3.select('#w')
        .attr('x', width() / 2)
        .attr('y', height () / 2);
});

var g = svg.append('g');

g.append('circle')
    .attr('cx', width() / 2)
    .attr('cy', height() / 2)
    .attr('stroke-width', 0)
    .attr('r', 155)
    .attr('fill', '#999')
    .style('filter', 'url(#glow)');

g.append('circle')
    .attr('id', 'c')
    .attr('cx', width() / 2)
    .attr('cy', height() / 2)
    .attr('stroke-width', 5)
    .attr('stroke', '#444')
    .attr('r', 150)
    .attr('fill', '#999');

g.append('text')
    .attr('id', 'w')
    .text('M')
    .style('font-size', 200)
    .style('filter', 'url(#glow)')
    .attr('text-anchor', 'middle')
    .attr('x', width() / 2)
    .attr('y', height() / 2)
    .attr('dy', '0.35em')
    .attr('stroke', '#fff')
    .attr('fill', '#fff');