<?php

require_once'connection.php';

$query = " SELECT * FROM posts";

$result  = mysqli_query( $connection,$query);

if($result){
    $response = array();
    while( $raw = mysqli_fetch_array($result)){

        $posts = array();

        $posts['id'] = $raw['id'];
        $posts['name'] = $raw['name'];
        $posts['location'] = $raw['location'];
        $posts['link_img_profile'] = $raw['link_img_profile'];
        $posts['link_img_post'] = $raw['link_img_post'];
        $posts['description'] = $raw['description'];
        $posts['comments'] = $raw['comments'];
        $posts['favorite'] = $raw['favorite'];

        array_push($posts,$response);
    }
}else{
    echo "Failure";
}

echo (json_encode($response));
mysqli_close($connection);

?>