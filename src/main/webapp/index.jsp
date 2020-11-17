<html>
<body>

<div class="w3-content" style="width:100%;height:100%">

<div class="w3-container w3-light-gray w3-left w3-border" style="width:25%;height:100%">
    <!--div class="w3-panel w3-light-blue w3-round-xlarge" style="width:90%;height:90%"-->
    <h4>Enter a <b>POI</b> , <b>ZipCode</b> and <b>Miles</b> to search for places.</h4>
    </br>

    <form action="getZipCodeInfo" method="GET">

        <h4>Search for POI:</h4>
        <input class="w3-input w3-border" type="text" name="param1" value="" />
        <h4>ZipCode:</h4>
        <input class="w3-input w3-border" type="text" name="param2" value="" />
        <h4>Miles:</h4>
        <input class="w3-input w3-border" type="text" name="param3" value="" />

        <button class="w3-button w3-dark-gray w3-padding-large w3-margin-bottom">Search</button>
        </br></br>

    </form>

    <a href="documentation.jsp">Click here</a> for the documentation.

</div>
</div>

</body>
</html>
