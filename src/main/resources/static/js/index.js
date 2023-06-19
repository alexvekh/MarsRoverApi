let marsApiButtons = document.querySelectorAll("button[id*='marsApi']");

marsApiButtons.forEach(button => button.addEventListener('click', function() {
  const buttonId = this.id;
  const roverId = buttonId.split('marsApi')[1];
  let apiData = document.getElementById('marsApiRoverData');
  apiData.value = roverId;
  document.getElementById('frmRoverType').submit()
}));

function getUrlParameter(name) {
  name = name.replace(/[\[]/, '\\[').replace(/[\]]/, '\\]');
  var regex = new RegExp('[\\?&]' + name + '=([^&#]*)');
  var results = regex.exec(location.search);
  return results === null ? '' : decodeURIComponent(results[1].replace(/\+/g, ' '));
};

const marsRoverType = getUrlParameter("marsApiRoverData");

if (marsRoverType == 'Curiosity') {
  document.getElementById('marsApiCuriosity').classList.remove('btn-secondary');
  document.getElementById('marsApiCuriosity').classList.add('btn-primary');
} else if (marsRoverType == 'Opportunity') {
  document.getElementById('marsApiOpportunity').classList.remove('btn-secondary');
  document.getElementById('marsApiOpportunity').classList.add('btn-primary');
  
} else if (marsRoverType == 'Spirit') {
  document.getElementById('marsApiSpirit').classList.remove('btn-secondary');
  document.getElementById('marsApiSpirit').classList.add('btn-primary');
} else {
  document.getElementById('marsApiOpportunity').classList.remove('btn-secondary');
  document.getElementById('marsApiOpportunity').classList.add('btn-primary');
} 
